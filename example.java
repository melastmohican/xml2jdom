private Element createPipeline() {
		Element elem = new Element("pipeline")
				.setAttribute(new Attribute("methods", "get"))
				.addContent(
						new Element("variable").setAttribute(
								new Attribute("name", "test")).setAttribute(
								new Attribute("select", "true()")))
				.addContent(
						new Element("variable").setAttribute(
								new Attribute("name", "test1")).setAttribute(
								new Attribute("select", "true()")))
				.addContent(
						new Element("while").setAttribute(
								new Attribute("test", "$test=true()"))
								.addContent(
										new Element("set").setAttribute(
												new Attribute("name", "test"))
												.setAttribute(
														new Attribute("select",
																"false()"))));
		return elem;
	}
