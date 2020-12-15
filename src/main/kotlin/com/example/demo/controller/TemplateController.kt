package com.example.demo.controller

import com.example.demo.DemoApplication
import fr.opensagres.odfdom.converter.core.utils.ByteArrayOutputStream
import fr.opensagres.xdocreport.converter.ConverterTypeTo
import fr.opensagres.xdocreport.converter.ConverterTypeVia
import fr.opensagres.xdocreport.converter.Options
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry
import fr.opensagres.xdocreport.template.TemplateEngineKind
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping(path = ["/template"])
class TemplateController {

    @PostMapping("/pdf")
    fun generatePdf(@RequestBody content: Map<String, Any>) : String {
        val template = DemoApplication::class.java.getResourceAsStream(content["fileName"].toString())!!
        val routeSheet = XDocReportRegistry.getRegistry().loadReport(template, TemplateEngineKind.Freemarker)
        val options = Options.getTo(ConverterTypeTo.PDF).via(ConverterTypeVia.ODFDOM)
        val context = routeSheet.createContext(content)
        ByteArrayOutputStream().use { os ->
            routeSheet.convert(context, options, os)
            return Base64.getEncoder().encodeToString(os.toByteArray())
        }
    }

}