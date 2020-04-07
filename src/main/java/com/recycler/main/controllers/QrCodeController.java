package com.recycler.main.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.recycler.main.dao.*;
import com.recycler.main.entities.*;

@RestController
@RequestMapping("qrcode")
public class QrCodeController {
	@Autowired
	private QRCodeDAO qrCodeDAO;
	
	@GetMapping
	public ResponseEntity<List<QrCode>> getQrCode(){
		List<QrCode> qrcodes = qrCodeDAO.findAll();
		return ResponseEntity.ok(qrcodes);
	}
	
	@PostMapping
	public ResponseEntity<QrCode> createQrCode(@RequestBody QrCode qrCode){
		QrCode newQrCode = qrCodeDAO.save(qrCode);
		return ResponseEntity.ok(newQrCode);
	}
	
	@RequestMapping(value="{qrCodeId}")
	public ResponseEntity<QrCode> getQrCodeById(@PathVariable("qrCodeId") Integer qrCodeId){
		Optional<QrCode>optionalQRCode = qrCodeDAO.findById(qrCodeId);
		if(!optionalQRCode.isPresent()) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok(optionalQRCode.get());
		}
	}

}
