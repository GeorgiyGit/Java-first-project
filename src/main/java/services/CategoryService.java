package services;

import clojure.core.reducers.Cat;
import dto.CategoryInsert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoryService {
    String conStr;
    String user;
    String password;

    public CategoryService(String conStr, String user, String password){
        this.conStr=conStr;
        this.user=user;
        this.password=password;
    }

    //Insert categories to db
    public void insert(CategoryInsert category){
        try(Connection connection = DriverManager.getConnection(conStr,user,password)){
            String query ="Insert into categories (name) values(?)";
            PreparedStatement command = connection.prepareStatement(query);
            command.setString(1,category.getName());
            command.executeUpdate();
        }
        catch (Exception ex){
            System.out.println("DB Error "+ ex.getMessage());
        }
    }


    //Get all categories from db
    public List<CategoryItem> getAll(){
        List<CategoryItem> categories = new ArrayList<CategoryItem>();
        try(Connection connection = DriverManager.getConnection(conStr,user,password)){
            String query ="SELECT * FROM categories";
            PreparedStatement command = connection.prepareStatement(query);
            ResultSet resultSet=command.executeQuery();
            while(resultSet.next()){
                CategoryItem item = new CategoryItem(resultSet.getInt("id"),resultSet.getString("name"));
                categories.add(item);
            }
            command.executeUpdate();
        }
        catch (Exception ex){
            System.out.println("DB Error "+ ex.getMessage());
        }
        return categories;
    }

    //remove one category by id
    public void remove(int id){
        try(Connection connection = DriverManager.getConnection(conStr,user,password)){
            String query ="DELETE FROM categories WHERE id=(?)";
            PreparedStatement command = connection.prepareStatement(query);
            command.setString(1,id+"");
            command.executeUpdate();
        }
        catch (Exception ex){
            System.out.println("DB Error "+ ex.getMessage());
        }
    }

    //updates one category
    public void update(CategoryItem newItem){
        try(Connection connection = DriverManager.getConnection(conStr,user,password)){
            String query ="UPDATE categories SET name=(?) WHERE id=(?)";
            PreparedStatement command = connection.prepareStatement(query);
            command.setString(1,newItem.getName());
            command.setString(2,newItem.getId()+"");

            command.executeUpdate();
        }
        catch (Exception ex){
            System.out.println("DB Error "+ ex.getMessage());
        }
    }
}
