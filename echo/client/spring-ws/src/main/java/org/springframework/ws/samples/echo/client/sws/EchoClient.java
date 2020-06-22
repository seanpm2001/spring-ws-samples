/*
 * Copyright 2007 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.ws.samples.echo.client.sws;

import java.io.IOException;

import javax.xml.transform.Source;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.xml.transform.ResourceSource;
import org.springframework.xml.transform.StringResult;

@Service
public class EchoClient extends WebServiceGatewaySupport {

	private static final Logger logger = LoggerFactory.getLogger(EchoClient.class);

	private Resource request;

	public void setRequest(Resource request) {
		this.request = request;
	}

	public void echo() throws IOException {

		Source requestSource = new ResourceSource(request);
		StringResult result = new StringResult();
		getWebServiceTemplate().sendSourceAndReceiveToResult(requestSource, result);

		logger.info(result.toString());
	}
}
