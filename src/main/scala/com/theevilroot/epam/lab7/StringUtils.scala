package com.theevilroot.epam.lab7

import scala.annotation.tailrec

object StringUtils {

  def first(in: String): Option[Char] = in.length match {
    case 0 => Option.empty
    case _ => Option(in.charAt(0))
  }

  @tailrec
  def handle(in: String, ret: String = ""): String = first(in) match {
    case None => ret
    case Some(a) if a.toLower < 'm' => handle(in.drop(1), ret.appended(a.toLower))
    case Some(a) => handle(in.drop(1), ret.appended(a.toUpper))
  }

}
