package com.danilo.sistemskeOperacije;

import com.danilo.broker.Broker;
import com.danilo.broker.IBroker;
import com.danilo.domen.HotelSlike;

public class HotelSlikeSO extends OpstaSistemskaOperacija {

	@Override
	protected void izvrsiKonkretnuOperacije(Object object) {
		HotelSlike hotelSlike = (HotelSlike) object;
		IBroker ib = new Broker();
		ib.sacuvaj(hotelSlike);

	}

}
