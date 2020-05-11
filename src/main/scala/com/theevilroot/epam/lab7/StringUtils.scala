package com.theevilroot.epam.lab7

object StringUtils {

  def foldl[A, B](f: (A, B) => B, a: B, in: List[A]): B = in match {
    case x :: rest => f(x, foldl(f, a, rest))
    case Nil => a
  }

  def map[A, B](in: List[A], f: A => B): List[B] =
    foldl[A, List[B]]((x, list) => list.appended(f(x)), List(), in)

  def join[A](in: List[A], f: A => String): String =
    foldl[A, String]((x, str) => str.concat(f(x)), "", in)

  def encrypt(f: Char => Char)(in: String): String =
     join[Char](map(in.toList, f), String.valueOf)

  def case_encrypt: String => String = encrypt({
      case x if x.toLower < 'm' => x.toLower
      case x => x.toUpper
    })

}
