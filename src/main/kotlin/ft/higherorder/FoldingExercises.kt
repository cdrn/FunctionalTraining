package ft.higherorder

import ft.recursion.FunList

/**
 * DO NOT ATTEMPT these exercises until you've completed the recursion ones.
 *
 * foldLeft will reduce a list of A's down to a B. It takes an initial value of type B
 * and a list of A's.  It also takes a function which takes the accumulated value of type B
 * and the next value in the list (of type A) and returns a value which will be feed back into
 * the accumulator of the next call.
 *
 * As the name suggests it processes the list from left to right.
 *
 * Have a close look at your implementations from the RecursionExercises.  Which parts could you
 * pull out to a function to make them all common? Your implementation will be very close to
 * foldLeft.
 *
 * Good luck!
 *
 */

object FoldingExercises {

  fun <A, B> foldLeft(initialValue: B, list: FunList<A>, f: (B, A) -> B): B = TODO("gotta implement")

  /**
   * foldRight is the same as foldLeft, except it processes the list from right to left.
   */
  fun <A, B> foldRight(initialValue: B, list: FunList<A>, f: (A, B) -> B): B = TODO("gotta implement")

  /**
   * Remember these, from our recursion exercises?  They can all be implemented with either
   * foldLeft or foldRight.
   */

  fun sum(x: FunList<Int>): Int = TODO("gotta implement")

  fun <A> length(x: FunList<A>): Int = TODO("gotta implement")

  //Careful you'll need a type annotation on the initialValue field
  fun <A, B> map(x: FunList<A>, f: (A) -> B): FunList<B> = TODO("gotta implement")

  fun <A> filter(x: FunList<A>, f: (A) -> Boolean): FunList<A> = TODO("gotta implement")

  fun <A> append(x: FunList<A>, y: FunList<A>): FunList<A> = TODO("gotta implement")

  fun <A> flatten(x: FunList<FunList<A>>): FunList<A> = TODO("gotta implement")

  fun <A, B> flatMap(x: FunList<A>, f: (A) -> FunList<B>): FunList<B> = TODO("gotta implement")

  // Maximum of the empty list is 0
  fun maximum(x: FunList<Int>): Int = TODO("gotta implement")

  fun <A> reverse(x: FunList<A>): FunList<A> = TODO("gotta implement")
}
