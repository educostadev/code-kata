package com.codekata;

public class Kata {

	static ListNode<Integer> removeKFromList(ListNode<Integer> node, int k) {

		//Se a entrada for null retornar null
		if (node == null) {
			return null;
		}

		//Encontrar o primeiro node diferente de K
		ListNode<Integer> currentNode = node;
		while (currentNode.next != null && currentNode.value == k) {
			currentNode = currentNode.next;
		}
		if (currentNode.value == k) {
			return null;
		}

		//Criar uma nova linkedList
		ListNode<Integer> newNode = new ListNode<>(currentNode.value);
		//Guardar a referencia do primeiro Node
		ListNode<Integer> first = newNode;
		//Mover para o proximo
		currentNode = currentNode.next;
		//Enquando houver proximo Node
		while (currentNode.next != null) {
			//Caso o valor seja != k entao fazer a ligacao com o proximo
			if (currentNode.value != k) {
				newNode.next = new ListNode<>(currentNode.value);
				//mover o novo node para o proximo que foi criado
				newNode = newNode.next;
			}
			//Mover havaliacao para o proximo
			currentNode = currentNode.next;
		}
		//Ultimo node nao foi havalidao
		if (currentNode.value != k){
			newNode.next = new ListNode<>(currentNode.value);
		}

		return first;
	}

}
