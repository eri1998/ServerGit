package com.danilo.niti;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
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
import com.danilo.kontrolerPL.KontrolerPL;
import com.danilo.operacije.Operacije;
import com.danilo.transferKlasa.TransferKlasa;

public class KlijentNit extends Thread {
	private Socket socket;
	public void setSocket(Socket socket) {
		this.socket = socket;
	}
	public void run() {
		while(true) {
			
				
				
					try {
						ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
						TransferKlasa transferKlasa = (TransferKlasa) ois.readObject();
						obradaKlijenta(transferKlasa);
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
			}
	}
	private void obradaKlijenta(TransferKlasa transferKlasa) {
		switch (transferKlasa.getOperacija()) {
		case Operacije.SACUVAJ_USERA:
			User user = (User) transferKlasa.getKlijent_objekat_request();
			KontrolerPL.getInstanca().sacuvajUser(user);
			TransferKlasa transferKlasa2 = new TransferKlasa();
			transferKlasa2.setPoruka("Uspesno ste se registrovali");
			posaljiNazad(transferKlasa2);
			break;
			
		case Operacije.LOGIN:
			User user1 = (User) transferKlasa.getKlijent_objekat_request();
			User user2= KontrolerPL.getInstanca().login(user1);
			TransferKlasa tk = new TransferKlasa();
			tk.setServer_objekat_response(user2);
			posaljiNazad(tk);
			break;
			
			case Operacije.SACUVAJ_DRZAVU:
				Drzava drzava = (Drzava) transferKlasa.getKlijent_objekat_request();
				Drzava drzava1 =  KontrolerPL.getInstanca().upisiDrzavu(drzava);
				TransferKlasa transferKlasa5 = new TransferKlasa();
				transferKlasa5.setServer_objekat_response(drzava1);
				posaljiNazad(transferKlasa5);
				break;
			
			case Operacije.VratiPoslednjuDrzavu:
				List<Drzava>list =   KontrolerPL.getInstanca().vratiPoslednjuDrzavu();
				TransferKlasa transferKlasa3 = new TransferKlasa();
				transferKlasa3.setServer_objekat_response(list);
				posaljiNazad(transferKlasa3);
				
				break;
			case Operacije.SACUVAJ_GRAD:
				Grad grad = (Grad) transferKlasa.getKlijent_objekat_request();
				Grad grad1 = KontrolerPL.getInstanca().upisiGrad(grad);
				TransferKlasa transferKlasa4 = new TransferKlasa();
				transferKlasa4.setServer_objekat_response(grad1);
				posaljiNazad(transferKlasa4);
				break;
				
			case Operacije.VRATI_GRAD:
				List<Grad>listGrad = KontrolerPL.getInstanca().vratiGradIzBaze();
				TransferKlasa transferKlasa6 = new TransferKlasa();
				transferKlasa6.setServer_objekat_response(listGrad);
				posaljiNazad(transferKlasa6);
				break;
				
			case Operacije.SACUVAJ_ADRESU:
				Adresa adresa = (Adresa) transferKlasa.getKlijent_objekat_request();
				Adresa adresa1 = KontrolerPL.getInstanca().upisiAdresu(adresa);
				TransferKlasa transferKlasa7 = new TransferKlasa();
				transferKlasa7.setServer_objekat_response(adresa1);
				posaljiNazad(transferKlasa7);
				break;
				
			case Operacije.VRATI_ADRESU:
				List<Adresa>adresaBaza = KontrolerPL.getInstanca().vratiAdresu();
				TransferKlasa transferKlasa8 = new TransferKlasa();
				transferKlasa8.setServer_objekat_response(adresaBaza);
				posaljiNazad(transferKlasa8);
				
				break;
				
			case Operacije.SACUVAJ_HOTEL:
				Hotel hotel = (Hotel) transferKlasa.getKlijent_objekat_request();
				Hotel hotel1 = KontrolerPL.getInstanca().sacuvajHotel(hotel);
				TransferKlasa transferKlasaHotel = new TransferKlasa();
				transferKlasaHotel.setServer_objekat_response(hotel1);
				posaljiNazad(transferKlasaHotel);
				break;
				
				case Operacije.SACUVAJ_SOBU:
					Soba soba = (Soba) transferKlasa.getKlijent_objekat_request();
					Soba soba1 = KontrolerPL.getInstanca().sacuvajSobu(soba);
					TransferKlasa klasa = new TransferKlasa();
					klasa.setServer_objekat_response(soba1);
					posaljiNazad(klasa);
					break;
					
				case Operacije.VRATI_SOBU:
					List<Soba> sobaBaza = KontrolerPL.getInstanca().vratiSobuIzBaze();
					TransferKlasa transferKlasa9 = new TransferKlasa();
					transferKlasa9.setServer_objekat_response(sobaBaza);
					posaljiNazad(transferKlasa9);
					break;
					
				case Operacije.SACUVAJ_SLIKE_SOBA:
					SobaSlike sobaSlike = (SobaSlike) transferKlasa.getKlijent_objekat_request();
					SobaSlike sobaSlike2 = KontrolerPL.getInstanca().sacuvajSlikeSoba(sobaSlike);
					TransferKlasa transferKlasa10 = new TransferKlasa();
					transferKlasa10.setServer_objekat_response(sobaSlike2);
					posaljiNazad(transferKlasa10);
					break;
				case Operacije.VRATI_SVE_SOBE:
					List<Soba>listSoba = KontrolerPL.getInstanca().vratiSveSobe();
					TransferKlasa transferKlasa11 = new TransferKlasa();
					transferKlasa11.setServer_objekat_response(listSoba);
					posaljiNazad(transferKlasa11);
					break;
				case Operacije.VRATI_UNETI_HOTEL:
					List<Hotel>listHotel=KontrolerPL.getInstanca().vratiUnetiHotel();
					TransferKlasa transferKlasa12 = new TransferKlasa();
					transferKlasa12.setServer_objekat_response(listHotel);
					posaljiNazad(transferKlasa12);
					break;
					
				case Operacije.SACUVAJ_USLUGE_SOBA:
					UslugeSoba uslugeSoba = (UslugeSoba) transferKlasa.getKlijent_objekat_request();
					UslugeSoba uslugeSobaNazad =KontrolerPL.getInstanca().sacuvajUslugeSoba(uslugeSoba);
					TransferKlasa transferKlasa13 = new TransferKlasa();
					transferKlasa13.setServer_objekat_response(uslugeSobaNazad);
					posaljiNazad(transferKlasa13);
					break;
				case Operacije.UPISI_USLUGE:
					UslugeHotel uslugeHotel = (UslugeHotel) transferKlasa.getKlijent_objekat_request();
					UslugeHotel uslugeHotelNazad = KontrolerPL.getInstanca().upisiUslugeHotel(uslugeHotel);
					TransferKlasa transferKlasa14 = new TransferKlasa();
					transferKlasa14.setServer_objekat_response(uslugeHotelNazad);
					posaljiNazad(transferKlasa14);
					break;
				case Operacije.SACUVAJ_SLIKE_HOTELA:
					HotelSlike hotelSlike = (HotelSlike) transferKlasa.getKlijent_objekat_request();
					HotelSlike hotelSlikeNazad = KontrolerPL.getInstanca().sacuvajSlikeHotela(hotelSlike);
					TransferKlasa transferKlasa15 = new TransferKlasa();
					transferKlasa15.setServer_objekat_response(hotelSlikeNazad);
					posaljiNazad(transferKlasa15);
					break;
				case Operacije.PRETRAZI:
					Hotel hotelPretraga = (Hotel) transferKlasa.getKlijent_objekat_request();
					List<Hotel>listPretrazenihHotela =  KontrolerPL.getInstanca().pretrazi(hotelPretraga);
					TransferKlasa transferKlasa16 = new TransferKlasa();
					transferKlasa16.setServer_objekat_response(listPretrazenihHotela);
					posaljiNazad(transferKlasa16);
					break;
				case Operacije.VRATI_SOBU_IZABRANOG_HOTELA:
					Soba soba2 = (Soba) transferKlasa.getKlijent_objekat_request();
					List<Soba> sobaIzabranogHotela = KontrolerPL.getInstanca().vratiSobuIzabranogHotela(soba2);
					TransferKlasa transferKlasa17 = new TransferKlasa();
					transferKlasa17.setServer_objekat_response(sobaIzabranogHotela);
					posaljiNazad(transferKlasa17);
					break;
				case Operacije.REZERVACIJA:
					RezervacijaSobe rezervacijaSobe = (RezervacijaSobe) transferKlasa.getKlijent_objekat_request();
					RezervacijaSobe	rezervacijeNazad = KontrolerPL.getInstanca().rezervacijaSobe(rezervacijaSobe);
					 TransferKlasa transferKlasa18 = new TransferKlasa();
						transferKlasa18.setServer_objekat_response(rezervacijeNazad);
						posaljiNazad(transferKlasa18);
					break;
				case Operacije.VRATI_REZERVACIJE:
					List<RezervacijaSobe>listRezervacijaSobe = KontrolerPL.getInstanca().vratiRezervaciije();
					 TransferKlasa transferKlasa19 = new TransferKlasa();
						transferKlasa19.setServer_objekat_response(listRezervacijaSobe);
						posaljiNazad(transferKlasa19);
					break;
		default:
			break;
		}
		
	}
	private void posaljiNazad(TransferKlasa tKlasa) {
		try {
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
			objectOutputStream.writeObject(tKlasa);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
