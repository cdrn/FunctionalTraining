package ft.recursion


// Taken from http://tmorris.net/posts/scala-exercises-for-beginners/index.html

/**
 * Ok here are the rules.
 *
 * You can't use any of the standard list functions, like `map`, `filter`, `flatMap`, `append`, `:::`, `:+`, etc.
 *
 * But you can always use `::` to construct a new list by prepending an element to another list.
 *
 * You CAN and are encouraged to use the solutions from the exercises below to solve the harder
 * ones towards the end.
 *
 * Keep an eye out for repetition and similarities between your answers.
 *
 * REMEMBER: Follow the types, they almost always guide you to the solution.  If it compiles and looks a little
 * too simple, it's probably correct.  As Sherlock Holmes once said, "Each one is suggestive, together they are
 * most certainly conclusive."
 *
 * See if you can make your solution tail recursive, where possible.
 *
 */

sealed class FunList<out A> {
  companion object {
    operator fun <A>invoke(vararg l:A ): FunList<A> = invoke(listOf(*l))
    operator fun <A>invoke(l:List<A>): FunList<A> = l.foldRight(Nil, { e:A, acc: FunList<A> -> Cons<A>(e,acc)})
  }
}


object Nil : FunList<Nothing>()
data class Cons<out A>(val head: A, val tail: FunList<A>): FunList<A>()

object RecursionExercises {

  fun plusOne(n: Int) = n + 1

  fun minusOne(n: Int) = n - 1

  // Add two non-negative Integers together.  You are only allowed to use plusOne and minusOne above
  fun add(a: Int, b: Int): Int = when(a) {
    0 -> b
    else -> add(minusOne(a), plusOne(b))
  }

  // You are not permitted to use any list functions such as map, flatMap, ++, flatten etc
   fun sum(l: FunList<Int>): Int {
    tailrec fun go(acc:Int, rest: FunList<Int>): Int = when(rest) {
      is Nil -> acc
      is Cons -> go(acc + rest.head, rest.tail)
    }
   return go(0, l)
  }

  //Again no list functions are permitted for the following
  fun <A> length(x: FunList<A>): Int =
    when(x) {
      is Nil -> 0
      is Cons -> 1 + length(x.tail)
    }


  // Do you notice anything similar between sum and length? Hmm...

  // Mapping over a list.  You are given a FunList of type A and a function converting an A to a B
  // and you give back a list of type B.  No list functions allowed!
  fun <A, B> map(x: FunList<A>, f: (A) -> B): FunList<B> {
    fun go(rest: FunList<A>): FunList<B> {
      return when(rest) {
        is Nil -> Nil
        is Cons -> Cons(f(rest.head), go(rest.tail))
      }
    }
    return go(x)
  }

  // Given a function from A -> Boolean, return a list with only those item where the function returned true.
  fun <A> filter(x: FunList<A>, f: (A) -> Boolean): FunList<A> {
    fun go(rest: FunList<A>): FunList<A> = when(rest) {
      is Nil -> Nil
      is Cons -> if (f(rest.head)) {
        Cons(rest.head, go(rest.tail))
      } else {
        go(rest.tail)
      }
    }
    return go(x)
  }

  // This pattern should be familiar by now... psst... look at add.
  fun <A> append(x: FunList<A>, y: FunList<A>): FunList<A> = when(x) {
    is Nil -> y
    is Cons -> Cons(x.head, append(x.tail, y))
  }

  // Flatten a list of lists to a single list.  Remember you can't use list.flatten.  Can you use a previous
  // solution to solve this one?
  fun <A> flatten(x: FunList<FunList<A>>): FunList<A> = when(x) {
    is Nil -> Nil
    is Cons -> append(x.head, flatten(x.tail))
  }

  // Follow the types.  You've done a great job getting here. Follow the types.
  fun <A, B> flatMap(x: FunList<A>, f: (A) -> FunList<B>): FunList<B> = flatten(map(x,f))

  // Maximum of the empty list is 0
  fun maximum(x: FunList<Int>): Int {
    tailrec fun go(max:Int, list: FunList<Int>): Int = when(list) {
      is Nil -> max
      is Cons -> {
        val newMax = if (list.head > max) list.head else max
        go(newMax, list.tail)
      }
    }

    return go(0, x)

  }

  // Reverse a list
  fun <A> reverse(x: FunList<A>): FunList<A> {
    tailrec fun go(acc: FunList<A>, rest:FunList<A>): FunList<A> = when(rest) {
      is Nil -> acc
      is Cons -> go(Cons(rest.head, acc), rest.tail)
    }
    return go(Nil, x)
  }
}
