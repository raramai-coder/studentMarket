# controls who sees what.
# added this
from rest_framework import serializer
from api.models import User, Location, Category, Product, Saved, Store, Tier, Review, Order, Security, DropPin


class ProductCardSerializer(serializer.HyperLinkedModelSerializer):
    class meta:
        model = Product
        fields = ('prodPicture', 'prodName', 'prodPrice', 'prodRating', 'prodRange')


class OrderSerializer(serializer.HyperLinkedModelSerializer):
    class meta:
        model = Order
        fields = ('quantity', 'prodName', 'orderAmount')
