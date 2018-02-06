package vn.plusplusc.ecommerce.service.wallet;

import org.springframework.beans.factory.annotation.Autowired;

import vn.plusplusc.ecommerce.database.model.Wallet;
import vn.plusplusc.ecommerce.repository.WalletRepository;

public class WalletServiceImpl implements WalletService{
    @Autowired 
    private WalletRepository walletRepository;

	@Override
	public Wallet findByUserId(String id) {
		// TODO Auto-generated method stub
		return walletRepository.findByUserId(id);
	}
	
}
