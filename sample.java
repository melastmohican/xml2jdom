private Element test() {
	Element elem = 
			new Element("pipeline")
			.setAttribute(new Attribute("methods","get"))
			.addContent(
	            new Element("variable")
	            .setAttribute(new Attribute("name","test"))
	            .setAttribute(new Attribute("select","'*'"))
			)
			.addContent(
	            new Element("variable")
	            .setAttribute(new Attribute("name","uriFile"))
	            .setAttribute(new Attribute("select","''"))
			)
			.addContent(
	            new Element("ddf")
	            .setAttribute(new Attribute("file","assets/small.zip"))
			)
			.addContent(
	            new Element("variable")
	            .setAttribute(new Attribute("name","key"))
	            .setAttribute(new Attribute("select","/BULK_TRANSITION/BATCH/BATCH_ID"))
			)
			.addContent(
	            new Element("variable")
	            .setAttribute(new Attribute("name","contentCreate"))
	            .setAttribute(new Attribute("select","/*"))
	            .addContent(
	            		new Element("include")
	            		.setAttribute(new Attribute("file","assets/contentCreate.xml"))
	            )
	        )
	        .addContent(
	            new Element("while")
	            .setAttribute(new Attribute("test","$test!=''"))
	            .addContent(
	            		new Element("replace")
	            		.setAttribute(new Attribute("select","$contentCreate"))
	            )
	            .addContent(
	            		new Element("set")
	            		.setAttribute(new Attribute("name","uriFile"))
	            		.setAttribute(new Attribute("select","/content/data/@ref"))
	            		.addContent(
	            				new Element("action")
	            				.setAttribute(new Attribute("method","post"))
	            				.setAttribute(new Attribute("resource","/elf/content"))
	            		)
	            )
	            .addContent(
	            		new Element("set")
	            		.setAttribute(new Attribute("name","test"))
	            		.setAttribute(new Attribute("select","/content/uri"))
	            		.addContent(
	            				new Element("documentStore")
	            				.setAttribute(new Attribute("uri","{uriFile}"))
	            				.setAttribute(new Attribute("key","{key}"))
	            		)
	            )
	        );
	return elem;
}