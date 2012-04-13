declare namespace fn="http://www.w3.org/2005/xpath-functions";
declare namespace local="http://www.w3.org/2005/xquery-local-functions";

declare variable $doc external;

(: .setAttribute(new Attribute("methods", "get")) :)
declare function local:getAttribute($atr) as xs:string {
	concat(".setAttribute(new Attribute(""",name($atr),""",""",string($atr),"""))
")
};

declare function local:getAttributes($ele) as xs:string {
	for $a in $ele/attribute::*
	return local:getAttribute($a)
};

(: new Element("pipeline") :)
declare function local:getElement($ele, $path as xs:string?) as xs:string {
	let $e := concat("new Element(""",name($ele),""")
")	
	let $a := local:getAttributes($ele)
	return concat($e,$a)
};

declare function local:getDocument() {
	<code>
	{local:getElement($doc/pathway/pipeline, ())}
	</code>
};

local:getDocument()
