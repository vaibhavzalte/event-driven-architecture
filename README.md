```text
                    ┌─────────────────┐
                    │   Eureka Server  │
                    │     :8761       │
                    └─────────────────┘
                            ▲
                            │
             registers with Eureka
                            │
          ┌─────────────────┴─────────────────┐
          │                                   │
┌───────────────────┐                ┌────────────────────┐
│   order-service   │                │ notification-service│
│      :8086        │                │       :8087         │
│                   │                │                     │
│ POST /orders      │                │ RabbitMQ Consumer   │
└─────────┬─────────┘                └──────────▲──────────┘
          │                                    │
          │ OrderCreatedEvent                  │
          ▼                                    │
   ┌──────────────────────────────────────────────────┐
   │                    RabbitMQ                      │
   │                                                  │
   │ Exchange: order-exchange                         │
   │                                                  │
   │ Routing: order.created                           │
   │                    │                             │
   │                    ▼                             │
   │             order-notification-queue             │
   └──────────────────────────────────────────────────┘

```
RabbitMQ architecture
```text
Producer
   │
   │ message
   ▼
Exchange
   │
   │ routing key
   ▼
Queue
   │
   ▼
Consumer
```
Our application:
```text
order-service
     │
     │ OrderCreatedEvent
     ▼
order-exchange
     │
     │ order.created
     ▼
order-notification-queue
     │
     ▼
notification-service
```


to analyze kafka used plungins 'Kafkalytic'