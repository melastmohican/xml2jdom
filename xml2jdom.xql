declare namespace fn="http://www.w3.org/2005/xpath-functions";
declare namespace local="http://www.w3.org/2005/xquery-local-functions";

declare variable $doc external;

(: .setAttribute(new Attribute("methods", "get")) :)
declare function local:getAttribute($atr) as xs:string {
	concat(".setAttribute(new Attribute(""",name($atr),""",""",string($atr),"""))
")
};

declare function local:getAttributes($ele) as xs:string {
	string-join(
    	(for $a in $ele/attribute::*
    	return local:getAttribute($a)
    	)
	,"")
};

declare function local:getContent($ele) as xs:string {
    if(not(empty($ele/child::*)))
    then      
        string-join(
            (for $e in $ele/child::*
            return concat(".addContent(
            ",local:getElement($e),")")
            )
        ,"") 
    else
        ""
    
};

(: new Element("pipeline") :)
declare function local:getElement($ele) as xs:string {
	let $e := concat("new Element(""",name($ele),""")
")	
	let $a := local:getAttributes($ele)
	let $c := local:getContent($ele)
	return concat($e,$a,$c)
};

declare function local:getDocument() {
	<code>
	{local:getElement($doc/*)}
	</code>
};

local:getDocument()
