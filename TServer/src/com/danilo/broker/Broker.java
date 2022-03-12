package com.danilo.broker;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.danilo.domen.Drzava;
import com.danilo.domen.Hotel;
import com.danilo.domen.OpstiDomen;
import com.danilo.domen.PretragaHotela;
import com.danilo.domen.Soba;
import com.danilo.domen.User;
import com.danilo.konekcija.Konekcija;

public class Broker implements IBroker {

	@Override
	public void sacuvaj(OpstiDomen opstiDomen) {
		String sql =  "insert into " +" "+opstiDomen.nazivTabele()+" "+opstiDomen.nazivKolone()+" "+opstiDomen.vrednostKolone() ;
		try {
			PreparedStatement preparedStatement = Konekcija.getInstanca().getConnection().prepareStatement(sql);
			preparedStatement = opstiDomen.vrati(preparedStatement);
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public User vratiUser(User user) {
		String sql = "SELECT * FROM"+" "+user.nazivTabele() +""+" where username = ? and password = ? ";
		User user2 = new User();
		try {
			PreparedStatement preparedStatement = Konekcija.getInstanca().getConnection().prepareStatement(sql);
			preparedStatement.setString(1,user.getUsername());
			preparedStatement.setString(2, user.getPassword());
			
			
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				user2.setUsername(resultSet.getString("username"));
				user2.setEmail(resultSet.getString("email"));
				user2.setFullName(resultSet.getString("fullName"));
				user2.setPassword(resultSet.getString("password"));
				user2.setIdUser(resultSet.getInt("idUser"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user2; 
		
	}

	@Override
	public List<OpstiDomen> vratiPoslednjiPodatakBaza(OpstiDomen opstiDomen) {
		String sql = " Select * from " +" "+opstiDomen.nazivTabele()+" "+"ORDER BY"+" "+opstiDomen.getID()+" "+"DESC LIMIT 1";
		List<OpstiDomen>list = new ArrayList<>();
		try {
			PreparedStatement preparedStatement = Konekcija.getInstanca().getConnection().prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			list = opstiDomen.vratiSelect(resultSet);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list; 
		
	}

	@Override
	public List<OpstiDomen> vratiFullTabeluBaza(OpstiDomen opstiDomen) {
		String sql = "Select * from "+opstiDomen.nazivTabele();
		List<OpstiDomen>listPodatakaBaza = new ArrayList<>();
		try {
			PreparedStatement preparedStatement = Konekcija.getInstanca().getConnection().prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			listPodatakaBaza = opstiDomen.vratiSelect(resultSet);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listPodatakaBaza;
	}

	@Override
	public List<Hotel> pretraga(Hotel hotel) {
		String sql = "SELECT * FROM HOTEL h "+"INNER JOIN hotelslike hs on  hs.idHotel=h.idHotel  AND h.naziv LIKE "+"'"+hotel.getKljucnaRec()+"%'" 
				+"INNER JOIN adresa a on h.idAdresa = a.idAdresa "
				+"INNER JOIN grad g on a.idGrad = g.idGrad "
				+"INNER JOIN drzava d on d.idDrzave = g.idGrad "
				+ "WHERE 1=1 ";
		
		
//		"SELECT * FROM Hotel h " + "INNER JOIN adresa a on h.id_adresa = a.id_adresa "
//		+ "INNER JOIN grad g on a.id_grad = g.id_grad " + "INNER JOIN drzava d on d.id_drzava = g.id_grad "
//		+ "INNER JOIN usluge u on u.id_hotel = h.id_hotel " + "INNER JOIN slike s on s.idHotel = h.id_hotel "
//		+ "WHERE 1=1 ";
//		AND hotel.naziv like '%' 
		
		List<Hotel>listHotels = new ArrayList<>();
		try {
			PreparedStatement preparedStatement = Konekcija.getInstanca().getConnection().prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			Hotel hotelNazad = null;
			while(resultSet.next()) {
				int idLastObject = resultSet.getInt(1);
				if(listHotels.isEmpty()) {
					hotelNazad = new Hotel();
					hotelNazad.getStatusFotografije().add(resultSet.getInt("statusFotografije"));
					//hotelNazad.setUrlSlika(resultSet.getString("urlSlike"));
					hotelNazad.setIdHotel(resultSet.getInt("idHotel"));
					hotelNazad.getUrlSlika().add(resultSet.getString("urlSlike"));
					hotelNazad.setBrZvezdica(resultSet.getString("brZvezdica"));
					hotelNazad.setIdAdresa(resultSet.getInt("idAdresa"));
					hotelNazad.setNazivHotel(resultSet.getString("naziv"));
					hotelNazad.setDrzava(resultSet.getString("drzava"));
					
					hotelNazad.setGrad(resultSet.getString("grad"));
					listHotels.add(hotelNazad);
				}else if(idLastObject == hotelNazad.getIdHotel()) {
					hotelNazad.getUrlSlika().add(resultSet.getString("urlSlike"));
					hotelNazad.getStatusFotografije().add(resultSet.getInt("statusFotografije"));
				}else if (idLastObject != hotelNazad.getIdHotel()) {
					hotelNazad = new Hotel();
					//hotelNazad.setUrlSlika(resultSet.getString("urlSlike"));
					hotelNazad.getUrlSlika().add(resultSet.getString("urlSlike"));
					hotelNazad.setBrZvezdica(resultSet.getString("brZvezdica"));
					hotelNazad.setIdAdresa(resultSet.getInt("idAdresa"));
					hotelNazad.setNazivHotel(resultSet.getString("naziv"));
					hotelNazad.setGrad(resultSet.getString("grad"));
					hotelNazad.setDrzava(resultSet.getString("drzava"));
					hotelNazad.setIdHotel(resultSet.getInt("idHotel"));
					hotelNazad.getStatusFotografije().add(resultSet.getInt("statusFotografije"));
					listHotels.add(hotelNazad);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listHotels;
	}

	@Override
	public List<Soba> sobaIzabranogHotela(Soba soba) {
		String sql = "Select * from soba inner join sobaSlike where soba.idSobe=sobaSlike.idSobe and soba.idHotel = "+""+""+soba.getIdHotel()+""+"";
		List<Soba>listSoba = new ArrayList<>();
		try {
			PreparedStatement preparedStatement = Konekcija.getInstanca().getConnection().prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			Soba soba2=null;
			while(resultSet.next()) {
				int idLastObject = resultSet.getInt(1);
				if(listSoba.isEmpty()) {
					soba2 = new Soba();
					soba2.setTipSobe(resultSet.getString("tipSobe"));
					soba2.setIdSobe(resultSet.getInt("idSobe"));
					soba2.setSpratSobe(resultSet.getInt("sprat"));
					soba2.setCenaSobe(resultSet.getInt("cena"));
					soba2.setPovrsinaSobe(resultSet.getInt("povrsina"));
					soba2.setBrSobe(resultSet.getInt("brSobe"));
					soba2.getUrl().add(resultSet.getString("urlSlike"));
					listSoba.add(soba2);
				}else if(idLastObject == soba2.getIdSobe()){
				    soba2.getUrl().add(resultSet.getString("urlSlike"));
				}else if(idLastObject != soba2.getIdSobe()){
					soba2 = new Soba();
					soba2.setTipSobe(resultSet.getString("tipSobe"));
					soba2.setIdSobe(resultSet.getInt("idSobe"));
					soba2.setSpratSobe(resultSet.getInt("sprat"));
					soba2.setCenaSobe(resultSet.getInt("cena"));
					soba2.setPovrsinaSobe(resultSet.getInt("povrsina"));
					soba2.setBrSobe(resultSet.getInt("brSobe"));
					soba2.getUrl().add(resultSet.getString("urlSlike"));
					listSoba.add(soba2);
				}
				 
				 
			
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listSoba;
	}

	
	

}
