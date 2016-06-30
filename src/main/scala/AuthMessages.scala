package codecraft.auth



final case class AddAuth(
  email: String,
  password: String
)

final case class AddAuthReply(
  token: Option[String],
  error: Option[String]
)

final case class GetAuth(
  email: String,
  password: String
)

final case class GetAuthReply(
  token: Option[String],
  error: Option[String]
)