package codecraft.auth

import codecraft.codegen.CmdGroupConsumer

trait IAuthService extends CmdGroupConsumer {
  def add(cmd: AddAuth): AddAuthReply
  def get(cmd: GetAuth): GetAuthReply
  val methodRegistry = Map[String, Any => Any](
    "cmd.auth.add" -> {
      any => add(any.asInstanceOf[AddAuth])
    },
    "cmd.auth.get" -> {
      any => get(any.asInstanceOf[GetAuth])
    }
  )
}