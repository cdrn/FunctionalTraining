package ft.referentialtransparency

/**
 * The IO type allows us to turn _any_ effectful code into a referentially transparent value.
 *
 * This type has been subsumed by Kotlin's coroutines which we will show later, but it is a great
 * way to understand how the patterns you already know help us solve the side-effect issue.
 */

data class IO<A>(val f: () -> A) {
  fun <B> map(f: (A) -> B): IO<B> = TODO()

  fun <B> flatMAp(f: (A) -> IO<B>): IO<B> = TODO()

  fun unsafeRun(): A = TODO()
}
