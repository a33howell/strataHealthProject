
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import java.lang._
import java.util._
import scala.collection.JavaConverters._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import play.data._
import play.core.j.PlayFormsMagicForJava._

object index extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[String,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(output1: String)(output2: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.36*/("""

"""),_display_(/*3.2*/main("Roman numeral converter")/*3.33*/ {_display_(Seq[Any](format.raw/*3.35*/("""

"""),format.raw/*5.1*/("""<html>
<head>
  <h1>ROMAN NUMERAL CONVERTER</h1>
</head>
<body>
  <div id="converter">
    <p></p>
    <form action=""""),_display_(/*12.20*/routes/*12.26*/.HomeController.toRomanNumeral()),format.raw/*12.58*/("""" method="get">
      <input type="text" name="intInput" placeholder="Enter an integer"/>
      <button id="button1">convert to Roman numeral</button>
      <p>RESULT -> """),_display_(/*15.21*/output1),format.raw/*15.28*/("""</p>
    </form>

    <form action=""""),_display_(/*18.20*/routes/*18.26*/.HomeController.fromRomanNumeral()),format.raw/*18.60*/("""" method="get">
      <input type="text" name="numeralInput" placeholder="Enter a Roman numeral"/>
      <button id="button2">convert to integer</button>
      <p>RESULT -> """),_display_(/*21.21*/output2),format.raw/*21.28*/("""</p>
    </form>
  </div>
</body>
</html>

""")))}),format.raw/*27.2*/("""
"""))
      }
    }
  }

  def render(output1:String,output2:String): play.twirl.api.HtmlFormat.Appendable = apply(output1)(output2)

  def f:((String) => (String) => play.twirl.api.HtmlFormat.Appendable) = (output1) => (output2) => apply(output1)(output2)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Sat Nov 03 12:28:15 MDT 2018
                  SOURCE: C:/Users/Owner/Desktop/strataHealthProject/playframework/app/views/index.scala.html
                  HASH: 4c89724fefdbe47abb922f76a48ed8ee8848ffa8
                  MATRIX: 955->1|1084->35|1114->40|1153->71|1192->73|1222->77|1374->202|1389->208|1442->240|1643->414|1671->421|1738->461|1753->467|1808->501|2012->678|2040->685|2120->735
                  LINES: 28->1|33->1|35->3|35->3|35->3|37->5|44->12|44->12|44->12|47->15|47->15|50->18|50->18|50->18|53->21|53->21|59->27
                  -- GENERATED --
              */
          