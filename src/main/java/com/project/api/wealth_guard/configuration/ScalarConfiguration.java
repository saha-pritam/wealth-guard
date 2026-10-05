package com.project.api.wealth_guard.configuration;

import graphql.GraphQLContext;
import graphql.execution.CoercedVariables;
import graphql.language.Value;
import graphql.scalars.ExtendedScalars;
import graphql.schema.*;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Configuration
public class ScalarConfiguration {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE;
    private static final Pattern ISO_LOCAL_DATE_PATTERN =
            Pattern.compile("^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])$");

    @Bean
    GraphQLScalarType localDate(){
        return GraphQLScalarType.newScalar()
                .name("LocalDate")
                .description("Custom scalar for java.time.LocalDate")
                .coercing(new Coercing<LocalDate, String>() {
                    @Override
                    public @Nullable String serialize(@NonNull Object dataFetcherResult, @NonNull GraphQLContext graphQLContext, @NonNull Locale locale) throws CoercingSerializeException {
                        if(dataFetcherResult instanceof LocalDate localDate){
                            return FORMATTER.format(localDate);
                        }
                        throw new CoercingSerializeException("Expected local date");
                    }

                    @Override
                    public @Nullable LocalDate parseValue(@NonNull Object input, @NonNull GraphQLContext graphQLContext, @NonNull Locale locale) throws CoercingParseValueException {
                        if(input instanceof LocalDate localDate){
                            return localDate;
                        }
                        throw new CoercingParseValueException("Expected local date");
                    }

                    @Override
                    public @Nullable LocalDate parseLiteral(@NonNull Value<?> input, @NonNull CoercedVariables variables, @NonNull GraphQLContext graphQLContext, @NonNull Locale locale) throws CoercingParseLiteralException {
                        Matcher matcher = ISO_LOCAL_DATE_PATTERN.matcher(input.toString());
                        if(matcher.matches()){
                            return LocalDate.parse(input.toString(), FORMATTER);
                        }
                        throw new CoercingParseLiteralException("Expected ISO-8601 local date literal");
                    }
                }).build();
    }

    @Bean
    RuntimeWiringConfigurer runtimeWiringConfigurer(){
         return runtimeWiringBuilder -> runtimeWiringBuilder
                 .scalar(ExtendedScalars.GraphQLBigDecimal)
                 .scalar(localDate());
    }
}
