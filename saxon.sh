#!/bin/bash
java -cp /opt/local/share/java/saxon8.jar net.sf.saxon.Query xml2jdom.xql +doc=sample.xml
