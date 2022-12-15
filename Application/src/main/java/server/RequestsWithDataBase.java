package server;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dataManagers.DAOOrganizations;
import dataManagers.DAOProducts;
import generated.tables.records.OrganizationsRecord;

import org.jetbrains.annotations.NotNull;

public class RequestsWithDataBase {
    private static final DAOProducts daoProducts = new DAOProducts();
    private static final DAOOrganizations daoOrganizations = new DAOOrganizations();
    public static boolean postFlag = true;

    public static String getRequest() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(daoProducts.all());
    }

    public static void postRequest(@NotNull String info) {
        var infoAboutProduct = info.split(";");
        var productName = infoAboutProduct[0];
        var organizationName = infoAboutProduct[1];
        var amount = Integer.parseInt(infoAboutProduct[2]);
        if (daoOrganizations.find(organizationName)) {
            daoOrganizations.save(new OrganizationsRecord(organizationName));
        }
        daoProducts.save(productName, organizationName, amount);
    }

}
