package codecraft.auth

import play.api.libs.json._
import codecraft.auth._
import codecraft.codegen._
import scala.util.Try

object AuthFormatters {
  implicit val AddAuthFormat = Json.format[AddAuth]
  implicit val AddAuthReplyFormat = Json.format[AddAuthReply]
  implicit val GetAuthFormat = Json.format[GetAuth]
  implicit val GetAuthReplyFormat = Json.format[GetAuthReply]
}

object AuthRoutingGroup {
  import AuthFormatters._
  val groupRouting = GroupRouting(
    "cmd.auth",
    "cmd.auth.*",
    "cmd"
  )
  lazy val cmdInfo = List(
    codecraft.codegen.CmdRegistry(
      "cmd.auth.add",
      (any: Any) => Try {
        val value = any.asInstanceOf[AddAuth]
        Json.toJson(value).toString.getBytes
      },
      (any: Any) => Try {
        val value = any.asInstanceOf[AddAuthReply]
        Json.toJson(value).toString.getBytes
      },
      (bytes: Array[Byte]) => Try {
        val json = Json.parse(new String(bytes))
        Json.fromJson[AddAuth](json) match {
          case JsError(errors) => throw new Exception(errors mkString)
          case JsSuccess(any, _) => any.asInstanceOf[AddAuth]
        }
      },
      (bytes: Array[Byte]) => Try {
        val json = Json.parse(new String(bytes))
        Json.fromJson[AddAuthReply](json) match {
          case JsError(errors) => throw new Exception(errors mkString)
          case JsSuccess(any, _) => any.asInstanceOf[AddAuthReply]
        }
      },
      groupRouting
    ),
    codecraft.codegen.CmdRegistry(
      "cmd.auth.get",
      (any: Any) => Try {
        val value = any.asInstanceOf[GetAuth]
        Json.toJson(value).toString.getBytes
      },
      (any: Any) => Try {
        val value = any.asInstanceOf[GetAuthReply]
        Json.toJson(value).toString.getBytes
      },
      (bytes: Array[Byte]) => Try {
        val json = Json.parse(new String(bytes))
        Json.fromJson[GetAuth](json) match {
          case JsError(errors) => throw new Exception(errors mkString)
          case JsSuccess(any, _) => any.asInstanceOf[GetAuth]
        }
      },
      (bytes: Array[Byte]) => Try {
        val json = Json.parse(new String(bytes))
        Json.fromJson[GetAuthReply](json) match {
          case JsError(errors) => throw new Exception(errors mkString)
          case JsSuccess(any, _) => any.asInstanceOf[GetAuthReply]
        }
      },
      groupRouting
    )
  )
}