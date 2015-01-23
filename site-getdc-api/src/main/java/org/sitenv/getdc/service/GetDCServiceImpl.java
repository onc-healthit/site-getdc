package org.sitenv.getdc.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class GetDCServiceImpl implements GetDCService {
	/*
	 * Implemented.
	 */
	public String discover(String endpoint, String pythonPath, String getDcPath) {
		try {
			Process p = Runtime.getRuntime().exec(
					new String[] { pythonPath, getDcPath,
							endpoint });
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					p.getInputStream()));
			StringBuilder builder = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null) {
				builder.append(line);
				builder.append(System.getProperty("line.separator"));
			}
			return builder.toString();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return StringUtils.EMPTY;
	}
}
