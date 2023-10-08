import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormControl } from '@angular/forms';

@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.css']
})
export class CheckoutComponent implements OnInit {
  checkoutForm!: FormGroup;

  totalPrice = 0;
  totalQuantity = 0;

  constructor(private formBuilder: FormBuilder) {
  }

  ngOnInit(): void {
      this.checkoutForm = new FormGroup({
      firstName: new FormControl(''),
      lastName: new FormControl(''),
      email: new FormControl('')
    }),

    this.checkoutForm = new FormGroup({
      customer: new FormGroup({
        firstName: new FormControl(),
        lastName: new FormControl(),
        email: new FormControl()
      }),
      shippingAddress: new FormGroup({
        street: new FormControl(),
        city: new FormControl(),
        state: new FormControl(),
        country: new FormControl(),
        zipCode: new FormControl()
      }),
      billingAddress: new FormGroup({
        street: new FormControl(),
        city: new FormControl(),
        state: new FormControl(),
        country: new FormControl(),
        zipCode: new FormControl()
      }),
      creditCard: new FormGroup({
        cardType: new FormControl(),
        cardHolder: new FormControl(),
        cardNumber: new FormControl(),
        expirationMonth: new FormControl(),
        expirationYear: new FormControl(),
        securityCode: new FormControl()
      })
    });
  }

  copyShippingToBilling = (event : any ): void => {
    if (event.target.checked) {
      this.checkoutForm.controls['billingAddress'].setValue(
        this.checkoutForm.controls['shippingAddress'].value
      );
    } else {
      this.checkoutForm.controls['billingAddress'].reset();
    }
  }

  onSubmit = (): void => {
   // console.log(this.checkoutForm.get('customer').value);

   console.log(this.checkoutForm.get('customer')?.value)
  }

}
