package com.danilo.kontrolerPL;

import java.util.ArrayList;
import java.util.List;

import com.danilo.domen.Adresa;
import com.danilo.domen.Drzava;
import com.danilo.domen.Grad;
import com.danilo.domen.Hotel;
import com.danilo.domen.HotelSlike;
import com.danilo.domen.OpstiDomen;
import com.danilo.domen.PretragaHotela;
import com.danilo.domen.RezervacijaSobe;
import com.danilo.domen.Soba;
import com.danilo.domen.SobaSlike;
import com.danilo.domen.User;
import com.danilo.domen.UslugeHotel;
import com.danilo.domen.UslugeSoba;
import com.danilo.sistemskeOperacije.AdresaBazaSO;
import com.danilo.sistemskeOperacije.AdresaSO;
import com.danilo.sistemskeOperacije.DrzavaBazaSO;
import com.danilo.sistemskeOperacije.DrzavaSO;
import com.danilo.sistemskeOperacije.GradBazaSO;
import com.danilo.sistemskeOperacije.GradSO;
import com.danilo.sistemskeOperacije.HotelPretragaSO;
import com.danilo.sistemskeOperacije.HotelSO;
import com.danilo.sistemskeOperacije.HotelSlikeSO;
import com.danilo.sistemskeOperacije.OpstaSistemskaOperacija;
import com.danilo.sistemskeOperacije.PoslednjiUnetiHotelSO;
import com.danilo.sistemskeOperacije.RezervacijeSO;
import com.danilo.sistemskeOperacije.SobaBazaSO;
import com.danilo.sistemskeOperacije.SobaIzabranogHotelaSO;
import com.danilo.sistemskeOperacije.SobaSO;
import com.danilo.sistemskeOperacije.SobaSlikeSO;
import com.danilo.sistemskeOperacije.UserLoginSO;
import com.danilo.sistemskeOperacije.UserSO;
import com.danilo.sistemskeOperacije.UslugeHotelSO;
import com.danilo.sistemskeOperacije.UslugeSobaSO;
import com.danilo.sistemskeOperacije.VratiRezervacijeSO;
import com.danilo.sistemskeOperacije.Vrati_SVE_SOBE_SO;

public class KontrolerPL {
private static volatile KontrolerPL instanca;
private KontrolerPL() {
	
}
public static KontrolerPL getInstanca() {
	if( instanca == null ) {
		synchronized (KontrolerPL.class) {
			if(instanca == null ) {
				instanca = new KontrolerPL();
			}
		}
	}return instanca;
}
public void sacuvajUser(User user) {
	OpstaSistemskaOperacija oso = new UserSO();
	oso.izvrsiSistemskeOperacije(user);
	
}
public User login(User user1) {
	List<User>list = new ArrayList<>();
	list.add(user1);
	OpstaSistemskaOperacija oso = new UserLoginSO();
	oso.izvrsiSistemskeOperacije(list);
	
	return list.get(1);
	
	
}
public Hotel sacuvajHotel(Hotel hotel) {
	OpstaSistemskaOperacija sistemskaOperacija = new HotelSO();
	sistemskaOperacija.izvrsiSistemskeOperacije(hotel);
	return hotel;
	
}
public Drzava upisiDrzavu(Drzava drzava) {
	OpstaSistemskaOperacija operacija = new DrzavaSO();
	operacija.izvrsiSistemskeOperacije(drzava);
	return drzava;

	
}

public List<Drzava> vratiPoslednjuDrzavu() {
	List<Drzava>list = new ArrayList<>();
	OpstaSistemskaOperacija sistemskaOperacija = new DrzavaBazaSO();
	sistemskaOperacija.izvrsiSistemskeOperacije(list);
	return list;
}
public Grad upisiGrad(Grad grad) {
    OpstaSistemskaOperacija sistemskaOperacija = new GradSO();
    sistemskaOperacija.izvrsiSistemskeOperacije(grad);
	return grad;
}
public List<Grad> vratiGradIzBaze() {
	List<Grad>listGrad = new ArrayList<>();
	OpstaSistemskaOperacija sistemskaOperacija = new GradBazaSO();
	sistemskaOperacija.izvrsiSistemskeOperacije(listGrad);
	return listGrad;
}
public Adresa upisiAdresu(Adresa adresa) {
	OpstaSistemskaOperacija operacija = new AdresaSO();
	operacija.izvrsiSistemskeOperacije(adresa);
	return adresa;
	
}
public List<Adresa> vratiAdresu() {
	List<Adresa>listAdresa = new ArrayList<>();
	OpstaSistemskaOperacija sistemskaOperacija = new AdresaBazaSO();
	sistemskaOperacija.izvrsiSistemskeOperacije(listAdresa);
	return listAdresa;
}
public Soba sacuvajSobu(Soba soba) {
	OpstaSistemskaOperacija operacija = new SobaSO();
	operacija.izvrsiSistemskeOperacije(soba);
	return soba;
	
	
}
public List<Soba> vratiSobuIzBaze() {
	List<Soba>sobaBaza = new ArrayList<>();
	OpstaSistemskaOperacija sistemskaOperacija = new SobaBazaSO();
	sistemskaOperacija.izvrsiSistemskeOperacije(sobaBaza);
	return sobaBaza;
}
public SobaSlike sacuvajSlikeSoba(SobaSlike sobaSlike) {
	OpstaSistemskaOperacija opstaSistemskaOperacija = new SobaSlikeSO();
	opstaSistemskaOperacija.izvrsiSistemskeOperacije(sobaSlike);
	return sobaSlike;
	
}
public List<Soba> vratiSveSobe() {
	List<Soba>listSoba = new ArrayList<>();
	OpstaSistemskaOperacija opstaSistemskaOperacija = new Vrati_SVE_SOBE_SO();
	opstaSistemskaOperacija.izvrsiSistemskeOperacije(listSoba);
	return listSoba;
}
public List<Hotel> vratiUnetiHotel() {
	List<Hotel>listHotel = new ArrayList<>();
	OpstaSistemskaOperacija operacija = new PoslednjiUnetiHotelSO();
	operacija.izvrsiSistemskeOperacije(listHotel);
	return listHotel;
}
public UslugeSoba sacuvajUslugeSoba(UslugeSoba uslugeSoba) {
	OpstaSistemskaOperacija opstaSistemskaOperacija = new UslugeSobaSO();
	opstaSistemskaOperacija.izvrsiSistemskeOperacije(uslugeSoba);
	return uslugeSoba;
	
	
}
public UslugeHotel upisiUslugeHotel(UslugeHotel uslugeHotel) {
	OpstaSistemskaOperacija opstaSistemskaOperacija = new UslugeHotelSO();
	opstaSistemskaOperacija.izvrsiSistemskeOperacije(uslugeHotel);
	return uslugeHotel;
}
public HotelSlike sacuvajSlikeHotela(HotelSlike hotelSlike) {
	OpstaSistemskaOperacija operacija = new HotelSlikeSO();
	operacija.izvrsiSistemskeOperacije(hotelSlike);
	return hotelSlike;
}
public List<Hotel> pretrazi(Hotel hotel) {
	//List<Hotel>listHotel = new ArrayList<>();
	OpstaSistemskaOperacija opstaSistemskaOperacija = new HotelPretragaSO();
	opstaSistemskaOperacija.izvrsiSistemskeOperacije(hotel);
	return hotel.getListHotels();
}
public List<Soba> vratiSobuIzabranogHotela(Soba soba2) {
	OpstaSistemskaOperacija operacija = new SobaIzabranogHotelaSO();
	operacija.izvrsiSistemskeOperacije(soba2);;
	return soba2.getListSoba();
}
public RezervacijaSobe rezervacijaSobe(RezervacijaSobe rezervacijaSobe) {
	
 OpstaSistemskaOperacija operacija = new RezervacijeSO();
	operacija.izvrsiSistemskeOperacije(rezervacijaSobe);
	return rezervacijaSobe;
	
}
public List<RezervacijaSobe> vratiRezervaciije() {
	List<RezervacijaSobe>listaRezervacija = new ArrayList<>();
	OpstaSistemskaOperacija operacija = new VratiRezervacijeSO();
	operacija.izvrsiSistemskeOperacije(listaRezervacija);
	return listaRezervacija;
}


}
 