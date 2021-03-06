package graphql.schema

import graphql.AssertException
import spock.lang.Specification

import static graphql.Scalars.GraphQLString
import static graphql.schema.GraphQLFieldDefinition.newFieldDefinition
import static graphql.schema.GraphQLObjectType.newObject

class GraphQLObjectTypeTest extends Specification {

    def "duplicate field definition fails"() {
        when:
        newObject().name("TestObjectType")
                .field(newFieldDefinition().name("NAME").type(GraphQLString))
                .field(newFieldDefinition().name("NAME").type(GraphQLString))
                .build()
        then:
        thrown(AssertException)
    }
}
