package com.inventory.test;

import java.util.Arrays;
import java.util.List;

import com.inventory.valuation.SimpleValuation;
import com.inventory.valuation.ValuationStrategy;
import com.inventory.notification.EmailNotifier;
import com.inventory.notification.Notifier;
import com.inventory.notification.SMSNotifier;
import com.inventory.service.InventoryManager;
import com.inventory.service.InventoryService;
import com.inventory.service.ReorderService;

public class InventoryManagementSystem {

	public static void main(String[] args) {

		List<Notifier> notifiers = Arrays.asList(new com.inventory.notification.EmailNotifier(), new SMSNotifier());

		ReorderService reorderService = new ReorderService(notifiers);

		ValuationStrategy valuation = new SimpleValuation();

		InventoryService inventoryService = new InventoryService(reorderService, notifiers, valuation);

		InventoryManager manager = new InventoryManager(inventoryService);

		manager.start();
	}

}
