package io.udash.wrappers.jquery_test

import org.scalatest.{Matchers, WordSpec}

class DomManipulationTest extends WordSpec with Matchers {
  import io.udash.wrappers.jquery._
  import scalatags.JsDom.all._

  "jQuery" should {
    "set text content of DOM element" in {
      val text = "test 123"
      val dom = div().render

      jQ(dom).text() should be("")
      dom.textContent should be("")

      jQ(dom).text(text)

      jQ(dom).text() should be(text)
      dom.textContent should be(text)
    }

    "set content of DOM element" in {
      val text = "test 123"
      val dom = div().render
      val content = span(ul(li(text))).render

      jQ(dom).html() should be("")
      dom.textContent should be("")

      jQ(dom).html(content)

      jQ(dom).html() should be(s"<span><ul><li>$text</li></ul></span>")
      jQ(dom).text() should be(text)
      dom.textContent should be(text)
    }

    "set DOM element attribute" in {
      val attrName = "attr"
      val attrValue = "val"
      val dom = div().render

      jQ(dom).attr(attrName) should be(None)

      jQ(dom).attr(attrName, attrValue)

      jQ(dom).attr(attrName) should be(Some(attrValue))
      dom.getAttribute(attrName) should be(attrValue)
    }
  }

}
