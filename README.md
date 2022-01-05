# External Static Processing

### DefaultHandler
The org.xml.sax.helpers.DefaultHandler has long been the de facto standard for writing XML parsers in Java. 
By extending this class, and implementing the startDocument(), endDocument(), startElement(), endElement(), and characters() methods, a developer can parse data in an XML document, for example to convert to Java objects, or to perform calculations to the data contained in the file.

### if..else if blocks
In order to process the tags, the simplest solution is to use if..else if blocks to process the values based on the tag name, for example
```Java
if ("tag1".equals(tagName)) {
  processTag1();
} else if ("tag2".equals(tagName)) {
  processTag2();
}
```
This has the disadvantage of generating exponentially larger blocks of code for XML files with larger numbers of unique tag names, in one or both of the startElement() and endElement() implementations

### switch statement
if...else if blocks can be replaced with `switch` statements to reduce code. 
```Java
switch (tagName) {
  case "tag1": 
    proceessTag1();
    break;
    
  case "tag2": 
    processTag2();
    break;
    
  default:
    processUnexpectedTag();
    break;
}
```


## EnumParser
An example of using enumeration values to parse an XML file
