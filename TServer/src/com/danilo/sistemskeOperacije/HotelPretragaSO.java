package com.danilo.sistemskeOperacije;

import java.util.ArrayList;
import java.util.List;

import com.danilo.broker.Broker;
import com.danilo.broker.IBroker;
import com.danilo.domen.Hotel;



public class HotelPretragaSO extends OpstaSistemskaOperacija {

	@Override
	protected void izvrsiKonkretnuOperacije(Object object) {
		Hotel hotel =  (Hotel) object;
		IBroker ib = new Broker();
		List<Hotel>list =ib.pretraga(hotel);
		
hotel.getListHotels().clear();
hotel.getListHotels().addAll(list);
	}

}
