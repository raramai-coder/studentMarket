from django.shortcuts import render
from rest_framework import viewsets

from api.serializer import ProductCardSerializer, OrderSerializer, UserSerializer, LocationSerializer
from api.models import User, Location, Category, Product, Saved, Store, Tier, Review, Order, Security, DropPin


# create viewset using serializer
# from api.serializer import FacilitatorSerializer
# from api.models import Facilitator
# Create your views here.
# class facilitatorViewset(viewsets.ModelViewSet):
#    queryset = Facilitator.objects.all().order_by('firstname') #specify how u want data to be returned. ordering etc
#    serializer_class = FacilitatorSerializer

class ProductCardViewSet(viewsets.ModelViewSet):
    queryset = Product.objects.all().order_by('prodRating')
    serializer_class = ProductCardSerializer

class UserViewSet(viewsets.ModelViewSet):
    queryset = User.objects.all()
    serializer_class = UserSerializer

class LocationViewSet(viewsets.ModelViewSet):
    queryset = Location.objects.all()
    serializer_class = LocationSerializer

class OrderViewSet(viewsets.ModelViewSet):
    queryset = Order.objects.all().order_by('orderDate')
    serializer_class = OrderSerializer
