package db;

import java.util.List;
import com.airline.models.Passenger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

public class PassengerDAOImp implements PassengerDAO
{
	private ConnectDb connection = new ConnectDb();

	public PassengerDAOImp()
	{
		//empty
	}

	@Override
	public List<Passenger> getAllPassenger() 
	{
		// TODO Auto-generated method stub
		try 
		{
			String req = "SELECT * FROM Passenger";
			PreparedStatement p=connection.getConnection().prepareStatement(req);
			ResultSet res =p.executeQuery();
			List<Passenger>list=new ArrayList<Passenger>();
			while (res.next())
			{
				String cin = res.getString("cin");
				String firstName = res.getString("firstName");
				String lastName=res.getString("lastName");
				Date datedob=res.getDate("dob");
				String gender=res.getString("gender");
				Passenger passenger=new Passenger(cin,firstName,lastName,datedob,gender);
				list.add(passenger);

			}
			return list;
		}
		catch (Exception ex)
		{
			System.out.println(ex.getMessage());
			return null;
		}
	}

	@Override
	public int addPassenger(Passenger p)
	{
		try
		{
			String req="INSERT INTO passenger(cin,firstName,lastName,dob,gender) VALUES (?,?,?,?,?)";
			PreparedStatement pr=connection.getConnection().prepareStatement(req);
			pr.setString(1, p.getCin());
			pr.setString(2, p.getFirstName());
			pr.setString(3,p.getLastName());
			pr.setDate(4,(java.sql.Date) p.getDob());
			pr.setString(5, p.getGender());
			pr.executeUpdate();
			return 1;
		}
		catch(Exception ex)
		{
			System.out.println("Error message"+ex.getMessage());
			return 0;
		}
	}

	@Override
	public int removePassenger(String cin)
	{
		// TODO Auto-generated method stub
		try
		{
			String req="DELETE FROM passenger WHERE cin=?";
			PreparedStatement pr=connection.getConnection().prepareStatement(req);
			pr.setString(1, cin);
			pr.executeUpdate();
			return 1;
		}
		catch(Exception ex)
		{
			System.out.println("Error message"+ex.getMessage());
			return 0;
		}
		
	}

	@Override
	public int updatePassenger(int id, Passenger p)
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Passenger findPassengerById(int numero)
	{
		// TODO Auto-generated method stub
		try 
		{
			Passenger passenger=new Passenger();
			String req = "SELECT * FROM Passenger where cin="+numero;
			PreparedStatement p=connection.getConnection().prepareStatement(req);
			ResultSet res =p.executeQuery();
			while (res.next())
			{
				String cin = res.getString("cin");
				String firstName = res.getString("firstName");
				String lastName=res.getString("lastName");
				Date datedob=res.getDate("dob");
				String gender=res.getString("gender");
				passenger=new Passenger(cin,firstName,lastName,datedob,gender);
			}
			return passenger;
		}
		catch (Exception ex)
		{
			System.out.println(ex.getMessage());
			return null;
		}

	}

	@Override
	public Passenger findPassengerByName(String name) 
	{
		// TODO Auto-generated method stub
		return null;
	}
}
