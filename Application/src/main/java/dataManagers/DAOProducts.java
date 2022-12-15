package dataManagers;

import commons.JDBCCredentials;
import generated.tables.pojos.Products;
import generated.tables.records.ProductsRecord;
import org.jetbrains.annotations.NotNull;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static generated.tables.Products.PRODUCTS;

public class DAOProducts {

    private @NotNull
    final Connection connection;
    private @NotNull
    DSLContext context;
    private static final JDBCCredentials CREDS = JDBCCredentials.DEFAULT;

    public DAOProducts() {
        try {
            connection = DriverManager.getConnection(CREDS.url(), CREDS.login(), CREDS.password());
            context = DSL.using(connection, SQLDialect.POSTGRES);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("No connection");
        }
    }

    public @NotNull
    ProductsRecord get(int id) {
        var record = context
                .select()
                .from(PRODUCTS)
                .where(PRODUCTS.ID.eq(id))
                .fetchOne();
        return new ProductsRecord(record.getValue(PRODUCTS.ID),
                record.getValue(PRODUCTS.NAME),
                record.getValue(PRODUCTS.ORGANIZATION),
                record.getValue(PRODUCTS.AMOUNT));
    }

    public @NotNull
    List<Products> all() {
        var result = context
                .select()
                .from(PRODUCTS)
                .fetch();
        var listOfProducts = new ArrayList<Products>();
        for (var record : result) {
            listOfProducts.add(new Products(
                    record.getValue(PRODUCTS.ID),
                    record.getValue(PRODUCTS.NAME),
                    record.getValue(PRODUCTS.ORGANIZATION),
                    record.getValue(PRODUCTS.AMOUNT)));
        }
        return listOfProducts;
    }

    public void save(String name, String org, int amount) {
        context.insertInto(PRODUCTS, PRODUCTS.NAME, PRODUCTS.ORGANIZATION, PRODUCTS.AMOUNT)
                .values(name, org, amount)
                .execute();
    }

    public boolean find(@NotNull ProductsRecord product) {
        var result = context.select()
                .from(PRODUCTS)
                .where(PRODUCTS.ID.eq(product.getId()))
                .fetchOne();
        return result.size() == 1;
    }
}
