package vn.plusplusc.ecommerce.service.wallet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.plusplusc.ecommerce.database.model.Wallet;
import vn.plusplusc.ecommerce.repository.WalletRepository;
@Service
public class WalletServiceImpl implements WalletService{
    @Autowired 
    private WalletRepository walletRepository;

	@Override
	public Wallet findByUserId(String id) {
		// TODO Auto-generated method stub
		return walletRepository.findByUserId(id);
	}

	@Override
	public void updateWallet(Wallet wallet) {
		// TODO Auto-generated method stub
		walletRepository.save(wallet);
	}
	
}
