// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/Owner/Desktop/strataHealthProject/playframework/conf/routes
// @DATE:Sat Nov 03 12:05:38 MDT 2018


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
