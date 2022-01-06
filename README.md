# External Static Processing Pattern

### DefaultHandler
The org.xml.sax.helpers.DefaultHandler has long been the de facto standard for writing XML parsers in Java. 
By extending this class, and implementing the startDocument(), endDocument(), startElement(), endElement(), and characters() methods, a developer can parse data in an XML document, for example to convert to Java objects, or to perform calculations to the data contained in the file.
| Method          | Use                                                                          |
|-----------------|------------------------------------------------------------------------------|
| `startDocument` | Code to run before parsing - creating objects, open database connection, etc |
| `endDocument`   | Code to run after parsing - handle objects, close database connection, etc   |
| `startElement`  | Method triggered when the opening tag of an XML element is parsed            |
| `endElement`    | Method triggered when the closing tag of an XML element is parsed            |
| `characters`    | Handle a value in an XML file, i.e. plain text                               |

### Processing patterns
#### if..else if blocks
In order to process the tags, the simplest solution is to use if..else if blocks to process the values based on the tag name, for example
```Java
if ("tag1".equals(tagName)) {
  processTag1();
} else if ("tag2".equals(tagName)) {
  processTag2();
}
```
This has the disadvantage of generating exponentially larger blocks of code for XML files with larger numbers of unique tag names, in one or both of the startElement() and endElement() implementations

#### switch statement
In order to reduce code, an if...else if block can be replaced with a `switch` statement
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

#### Enumeration
But these methods do not reduce the code in the source file, at best the code is moved to another part of the same file. So what else can be done?
The `startElement()` and `endElement()` methods contain the most code, since they are triggered by the largest part of any XML file - the XML tags themselves. 
Look at both method signatures - `startElement(String namespaceURI, String lName, String qName, Attributes attributes)` and `endElement(String namespaceURI, String sName, String qName)`
What if the code from these methods was externalised from the class completely?

##### Interface
First, create two interfaces, `StartTag` and `EndTag`, and add the relevant method from DefaultHandler, i.e. `startElement()` and `endElement()` , to the relevant interface as an abstract method

#### Enumeration
Next, implement each interface in two enumerations, and create values in each enumeration that implement the method from the interface. Each value uses a tag from the XML as an id.

#### EnumParser
An example of using enumeration values to parse an XML file
