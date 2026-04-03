package com.inventry.test;

import java.util.Arrays;
import java.util.List;

import com.inventory.valuation.SimpleValuation;
import com.inventory.valuation.ValuationStrategy;
import com.inventry.notification.EmailNotifier;
import com.inventry.notification.Notifier;
import com.inventry.notification.SMSNotifier;
import com.inventry.service.InventoryManager;
import com.inventry.service.InventoryService;
import com.inventry.service.ReorderService;

public class InventoryManagementSystem {

	public static void main(String[] args) {

		List<Notifier> notifiers = Arrays.asList(new EmailNotifier(), new SMSNotifier());
		ReorderService reorderService = new ReorderService(notifiers);

		ValuationStrategy valuation = new SimpleValuation();

		InventoryService inventoryService = new InventoryService(reorderService, notifiers,valuation);
		
		InventoryManager manager = new InventoryManager(inventoryService);
		
		manager.start();
	}

}
