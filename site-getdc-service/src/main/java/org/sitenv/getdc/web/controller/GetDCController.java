package org.sitenv.getdc.web.controller;

import java.io.IOException;

import org.sitenv.common.utilities.controller.BaseController;
import org.sitenv.getdc.service.GetDCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/getdc/", produces=MediaType.APPLICATION_JSON_VALUE)
public class GetDCController extends BaseController
{
	@Autowired
	private GetDCService service;

	@RequestMapping(value="/discover/", method=RequestMethod.GET, produces="application/json; charset=utf-8")
	public @ResponseBody String discover(@RequestParam(value="endpoint", required=true) String endpoint) throws IOException 
	{
		if (this.props == null)
		{
			this.loadProperties();
		}
		
		return service.discover(endpoint, this.props.getProperty("pythonPath"), this.props.getProperty("getDcPath"));
	}
}
