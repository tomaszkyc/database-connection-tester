package com.tomaszkyc.app.builder;

import java.util.List;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.JCommander.Builder;
import com.tomaszkyc.app.args.ArgParameter;
import com.tomaszkyc.app.args.ArgParameterFactory;

public class AppBuilder {

	private List<ArgParameter> parameters;

	public List<ArgParameter> getParameters() {
		return parameters;
	}

	public void setParameters(List<ArgParameter> parameters) {
		this.parameters = parameters;
	}

	public JCommander build() {

		Builder builder = JCommander.newBuilder();
		this.parameters = ArgParameterFactory.create();

		buildParameterList(builder);
		return builder.build();
	}

	private void buildParameterList(Builder builder) {

		this.parameters.forEach(parameter -> {
			builder.addObject(parameter);
		});

	}

}
