package com.danilo.sistemskeOperacije;

import java.util.List;

import com.danilo.broker.Broker;
import com.danilo.broker.IBroker;
import com.danilo.domen.Soba;

public class SobaIzabranogHotelaSO extends OpstaSistemskaOperacija {

	@Override
	protected void izvrsiKonkretnuOperacije(Object object) {
	Soba soba = (Soba) object;
	IBroker ib = new Broker();
	soba.setListSoba(ib.sobaIzabranogHotela(soba));
	

	}

}
