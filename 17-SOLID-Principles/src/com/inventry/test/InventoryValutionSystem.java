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

public class InventoryValutionSystem {

	public static void main(String[] args) {

		ReorderService reorderService = new ReorderService();

		List<Notifier> notifiers = Arrays.asList(new EmailNotifier(),
												 new SMSNotifier());

		ValuationStrategy valuationStrategy = new SimpleValuation();

		InventoryService inventoryService = new InventoryService(reorderService, notifiers, valuationStrategy);

		InventoryManager manager = new InventoryManager(inventoryService);

		manager.start();

	}

}
