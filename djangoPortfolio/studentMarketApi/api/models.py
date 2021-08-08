from django.db import models

# Create your models here.
# added this
from django.forms import forms


class Location:
    pass


class User(models.Model):
    userID = models.IntegerField(primary_key=True)
    locationID = models.ForeignKey(Location, on_delete=models.CASCADE)
    userName = models.CharField(max_length=100, blank=False)
    userEmail = models.EmailField(max_length=100, null=False, blank=False)
    userPhoneNumber = models.IntegerField(max_length=11, null=True, blank=True)
    userUniversity = models.CharField(max_length=100, null=False, blank=False)
    userPassword = models.CharField(max_length=20, widget=forms.PasswordInput)


class Product:
    pass


class Saved(models.Model):
    savedID = models.IntegerField(primary_key=True)
    prodID = models.ForeignKey(Product, on_delete=models.RESTRICT)
    userID = models.ForeignKey(User, on_delete=models.RESTRICT)
    dateSaved = models.DateTimeField(verbose_name="Saved on", auto_now_add=True, null=True)


class Store(models.Model):
    storeID = models.IntegerField(primary_key=True)
    prodID = models.ForeignKey(Product, on_delete=models.CASCADE)
    userID = models.ForeignKey(User, on_delete=models.RESTRICT)
    storeName = models.CharField(max_length=100, null=False, blank=False)


class Tier(models.Model):
    tierID = models.IntegerField(primary_key=True)
    prodID = models.ForeignKey(Product, on_delete=models.RESTRICT)
    userID = models.ForeignKey(User, on_delete=models.RESTRICT)
    tierName = models.CharField(max_length=100, null=True, blank=True)
    tierDescription = models.CharField(max_length=250, null=False, blank=False)
    tierPrice = models.DecimalField(max_length=19, decimal_places=2, null=False, blank=False)


class Review(models.Model):
    reviewID = models.IntegerField(primary_key=True)
    prodID = models.ForeignKey(Product, on_delete=models.RESTRICT)
    userID = models.ForeignKey(User, on_delete=models.RESTRICT)
    reviewStars = models.IntegerField(max_length=5, null=True, blank=True)
    reviewDescription = models.CharField(max_length=250, null=True, blank=True)



class Product(models.Model):
    prodID = models.IntegerField(primary_key=True)
    categoryID = models.ForeignKey(Category, on_delete=models.CASCADE)
    userID = models.ForeignKey(User, on_delete=models.RESTRICT)
    prodName = models.CharField(max_length=100, null=False, blank=False)
    prodDescription = models.CharField(max_length=250, null=True, blank=True)
    prodPrice = models.DecimalField(max_length=19, decimal_places=2, null=False, blank=False)
    prodRange = models.IntegerField(max_field=100, null=True, blank=True)
    deliveryChoice = "Delivery"
    dropPinChoice = "Drop Pin"
    houseCallChoice = "House Call"
    # collectionChoice = "Collection"
    DeliveryOptions = [
        (deliveryChoice, 'Delivery'),
        (dropPinChoice, 'Drop Pin'),
        (houseCallChoice, 'House Call'),
    ]
    prodDelivery = models.CharField(max_length=9, choices=DeliveryOptions
                                    , default=dropPinChoice, null=False, blank=False)
    prodPicture = models.ImageField(upload_to='Photos', null=False, blank=False)
    prodLive = models.BooleanField(null=False)
    servTime = models.DateTimeField(verbose_name="Saved on", auto_now_add=True, null=True, blank=True)
    


class Category(models.Model):
    categoryID = models.IntegerField(primary_key=True)
    catName = models.CharField(max_length=100, null=False, blank=False)
    catSumProducts = models.IntegerField(max_length=100, null=True, blank=True)


class Location:
    pass


class Order(models.Model):
    orderID = models.IntegerField(primary_key=True)
    prodID = models.ForeignKey(Product, on_delete=models.RESTRICT)
    userID = models.ForeignKey(User, on_delete=models.RESTRICT)
    locationID = models.ForeignKey(Location, on_delete=models.RESTRICT)
    prodName = models.CharField(max_length=100, null=False, blank=False)
    orderNote = models.CharField(max_length=250, null=True, blank=True)
    orderAmount = models.DecimalField(max_length=19, decimal_places=2, null=False, blank=False)
    unitPrice = models.DecimalField(max_length=19, decimal_places=2, null=False, blank=False)
    quantity = models.CharField(max_field=100, null=False, blank=False)
    orderDate = models.DateTimeField(verbose_name="Ordered on", auto_now_add=True, null=True, blank=True)


class Location(models.Model):
    locationID = models.IntegerField(primary_key=True)
    longitude = models.DecimalField(max_length=19, decimal_places=4, null=False, blank=False)
    latitude = models.DecimalField(max_length=19, decimal_places=4, null=False, blank=False)


class Security:
    pass


class DropPin(models.Model):
    dropPinID = models.IntegerField(primary_key=True)
    securityID = models.ForeignKey(Security, on_delete=models.CASCADE)
    locationID = models.ForeignKey(Location, on_delete=models.RESTRICT)
    dropPinName = models.CharField(max_length=19, null=False, blank=False)
    dropPinUniversity = models.CharField(max_length=100, null=False, blank=False)


class Security(models.Model):
    securityID = models.IntegerField(primary_key=True)
    userID = models.ForeignKey(User, on_delete=models.RESTRICT)
    locationID = models.ForeignKey(Location, on_delete=models.RESTRICT)
    securityGuardPresence = models.BooleanField(null=False)
    none = "No Crowd Presence"
    moderate = "Moderate Presence (5-10 people in vicinity)"
    vast = "Vast Presence (10+ people in vicinity)"
    PresenceOptions = [
        (none, 'No Crowd Presence'),
        (moderate, 'Moderate Presence (5-10 people in vicinity)'),
        (vast, 'Vast Presence (10+ people in vicinity)'),
    ]
    locationCrowdPresence = models.CharField(max_length=100, choices=PresenceOptions
                                             , default=vast, null=False, blank=False)
    calm = "Little to No Movement (e.g Library"
    mild = "Mild Movement (e.g Coffee Shop )"
    rapid = "Vast Presence (e.g bus stop, mall)"
    movementOptions = [
        (calm, 'Little to No Movement (e.g Library'),
        (mild, 'Mild Movement (e.g Coffee Shop'),
        (rapid, 'Vast Presence (e.g bus stop, mall'),
    ]
    locationCrowdMovement = models.CharField(max_length=100, choices=movementOptions
                                             , default=mild, null=False, blank=False)
    safe = models.BooleanField(null=False)
    # get SAPS/university security to increase presence in unsafe areas.
    insecure = "Unsafe"
    moderateSecurity = "Moderate Security"
    secure = "Secure"
    SafetyTuple = [
        (insecure, 'Unsafe'),
        (moderateSecurity, 'Moderate Security'),
        (secure, 'Secure'),
    ]
    userReports = dropPinName = models.CharField(max_length=250, null=False, blank=False)
    # if bad user reported, disable account
