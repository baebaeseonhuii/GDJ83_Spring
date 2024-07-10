package com.seonhui.app.records;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seonhui.app.accounts.AccountDAO;
import com.seonhui.app.accounts.AccountDTO;

@Service
public class RecordService {

	@Autowired
	private RecordDAO recordDAO;

	@Autowired
	private AccountDAO accountDAO;

	public int record(RecordDTO recordDTO) throws Exception {
		// ~02계좌에서 ~67 계좌로 5000 줌 - 출금 DTO
		AccountDTO accountDTO = new AccountDTO();
		accountDTO.setAc_num(recordDTO.getAc_num());
		accountDTO = accountDAO.detail(accountDTO);

		if (accountDTO.getAccount_balance() < recordDTO.getMoney()) {
			return 0;
		}

		// 거래 내역 추가
		recordDTO.setType_of_transaction("출금");
		int result = recordDAO.add(recordDTO);

		// 거래 내용 업데이트
		result = recordDAO.update(recordDTO);

		// 입금 DTO로 수정
		recordDTO.setType_of_transaction("입금");

		// 받는 계좌 거래내역 추가
		result = recordDAO.add(recordDTO);

		// 받는 거래 내용 업데이트
		result = recordDAO.update(recordDTO);
		return result;

	}
}
