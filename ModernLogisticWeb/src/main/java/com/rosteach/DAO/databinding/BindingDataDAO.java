package com.rosteach.DAO.databinding;

import java.util.List;

import com.rosteach.entities.ClientRequest;

public interface BindingDataDAO {
	public List<ClientRequest> getClientsRequests(String database, String username, String password, String inputIds);
	public List<Integer> setClientsRequests(List<ClientRequest> clientsRequests,String database, String username, String password,
			String inputIds);
}
