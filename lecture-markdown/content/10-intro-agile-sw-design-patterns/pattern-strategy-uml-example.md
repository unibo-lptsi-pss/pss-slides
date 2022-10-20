
```mermaid
classDiagram 

class Person { }

class PersonCompareStrategy {
    <<interface>>
}

class PersonComparatorByFullName { }

class PersonComparatorByAge { }

PersonCompareStrategy <|-- PersonComparatorByFullName
PersonCompareStrategy <|-- PersonComparatorByAge

PersonComparatorByFullName --> Person 
PersonComparatorByAge --> Person

class UsePersons { }

UsePersons *-- PersonCompareStrategy
```