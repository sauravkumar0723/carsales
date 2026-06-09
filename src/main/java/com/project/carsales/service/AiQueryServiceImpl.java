package com.project.carsales.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AiQueryServiceImpl implements AiQueryService {

    //spring ai use when we need ChatClient
    private  final ChatClient chatClient;
    // we use Sprring jdbc. / jdbc template class need
    private final JdbcTemplate jdbcTemplate;


    public AiQueryServiceImpl(ChatClient.Builder builder, JdbcTemplate jdbcTemplate) {
        this.chatClient = builder.build();
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public String process(String question) {
        String sql = generateSQl(question);
        System.out.println(sql);

        if (sql.equalsIgnoreCase("INVALID")){
            return "X: Only table related Question allowed";
        }
        // check true of false are coming or not
        if (!isSafe(sql)) {
            return "X: Unsafe Query";
        }
        try {
            List<Map<String, Object>> result = jdbcTemplate.queryForList(sql);

            if (result.isEmpty()) {
                return "No data found";
            }
            System.out.println(result);

            return toNaturalLanguage(question,result);

        } catch (Exception e) {
            return "Query failed";
        }
    }

    // convert Result:-> Human friendly message

    private String toNaturalLanguage(String question, List<Map<String, Object>> result) {
        String prompt = """
                        Convert database result into a human readable answer.
                        
                        User Question:
                        """ + question + """
                        
                        DB Result:
                        """ + result.toString() + """
                        
                        
                        Rules:
                        - Answer clearly (don't write too much)
                        - Do not show JSON
                        - Do not explain SQL
                        """;

        return chatClient.prompt()
                .user(prompt)
                .call()
                .content()
                .trim();
    }


                //Validation
                // put in isSafe method
                private boolean isSafe(String sql) {
                    String lower = sql.toLowerCase();
                    return lower.startsWith("select")
                            && !lower.contains("drop")
                            && !lower.contains("delete")
                            && !lower.contains("update")
                            && !lower.contains("insert");
    }

    // we use ChatClient so i am create a method
    //then convert in Sql query with the help of Spring AI

    private String generateSQl(String question) {
       // promt from sql generator
        String prompt = """
                You are a SQL generator.

                Table: car_sales
                Columns: id, brand, car_number, city, color, contact_number, customer_name, date_of_purchase, email, engine, fuel_type, mileage, model, payment_mode, price, state, time_of_purchase, warranty_period, year

                Rules:
                 Only SELECT queries
                 Use only given columns
                 If not related, return: INVALID
                 Return only SQL(Do not wirte anything like here is there or sql...)
                 Question:
                """ + question;
        return  chatClient.prompt().user(prompt).call().content().trim();
    }


}
