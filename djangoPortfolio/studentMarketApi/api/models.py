from django.db import models

# Create your models here.
# added this
from django.forms import forms


class User(models.Model):
    userID = models.IntegerField(primary_key=True)
    userName = models.CharField(max_length=100, blank=False)
    userEmail = models.EmailField(max_length=100, null=False, blank=False)
    userPhoneNumber = models.IntegerField(max_length=11, null=True, blank=True)
    userUniversity = models.CharField(max_length=100, null=False, blank=False)
    userPassword = models.CharField(max_length=20, widget=forms.PasswordInput)


class Saved(models.Model):
    savedID = models.IntegerField(primary_key=True)
    # prodID = models.IntegerField(foreign_key=True)
    # userID = models.IntegerField(foreign_key=True)
    dateSaved = models.DateTimeField(verbose_name="Saved on", auto_now_add=True, null=True)


class Store(models.Model):
    storeID = models.IntegerField(primary_key=True)
    # prodID = models.IntegerField(foreign_key=True)
    # userID = models.IntegerField(foreign_key=True)
    storeName = models.CharField(max_length=100, null=False, blank=False)


class Tier(models.Model):
    tierID = models.IntegerField(primary_key=True)
    # prodID = models.IntegerField(foreign_key=True)
    # userID = models.IntegerField(foreign_key=True)
    tierName = models.CharField(max_length=100, null=True, blank=True)
    tierDescription = models.CharField(max_length=250, null=False, blank=False)
    tierPrice = models.DecimalField(max_length=19, decimal_places=2, null=False, blank=False)


class Review(models.Model):
    reviewID = models.IntegerField(primary_key=True)
    # prodID = models.IntegerField(foreign_key=True)
    # userID = models.IntegerField(foreign_key=True)
    reviewStars = models.IntegerField(max_length=5, null=True, blank=True)
    reviewDescription = models.CharField(max_length=250, null=True, blank=True)

class Product(models.Model):
    prodID = models.IntegerField(primary_key=True)
    # categoryID = models.IntegerField(foreign_key=True)
    # userID = models.IntegerField(foreign_key=True)
    prodName = models.CharField(max_length=100, null=False, blank=False)
    prodDescription = models.CharField(max_length=250, null=True, blank=True)
    prodPrice = models.DecimalField(max_length=19, decimal_places=2, null=False, blank=False)
    prodRange = models.IntegerField(max_field=100, null=True, blank=True)
    prodDelivery
    prodPicture = models.ImageField()
