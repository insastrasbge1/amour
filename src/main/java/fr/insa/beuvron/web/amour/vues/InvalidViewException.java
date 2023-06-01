/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.beuvron.web.amour.vues;

import com.vaadin.flow.component.notification.Notification;

/**
 *
 * @author francois
 */
class InvalidViewException extends Exception {

    public InvalidViewException(String message) {
        super(message);
    }
    
    public void notificationVaadin() {
        Notification.show("Invalid view : " +this.getMessage());
    }
}
