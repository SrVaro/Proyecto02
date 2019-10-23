import { Component, OnInit } from '@angular/core';
import { Profile } from '../profile';
import { ActivatedRoute, Router } from '@angular/router';
import { ProfileService } from '../profile.service';

@Component({
  selector: 'app-profile-form',
  templateUrl: './profile-form.component.html',
  styleUrls: ['./profile-form.component.css']
})
export class ProfileFormComponent {

  profile: Profile;
  category: Category[];

 
  constructor(private route: ActivatedRoute, private router: Router, private profileService: ProfileService) {
    this.profile = new Profile();
  }
 
  onSubmit() {
    this.profileService.save(this.profile).subscribe(result => this.gotoHome());
  }
 
  gotoHome() {
    this.router.navigate(['/home']);
  }
}
