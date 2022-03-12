package com.danilo.sistemskeOperacije;

import java.util.List;

import com.danilo.broker.Broker;
import com.danilo.broker.IBroker;
import com.danilo.domen.User;

public class UserLoginSO extends OpstaSistemskaOperacija{

	@Override
	protected void izvrsiKonkretnuOperacije(Object object) {
		List<User>list=(List<User>) object;
		User user = list.get(0);
		IBroker ib = new Broker();
		User user2 = ib.vratiUser(user);
		list.add(user2);
	}

}
